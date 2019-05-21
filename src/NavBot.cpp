#include "ActionExploreVelocity.h"
#include "ActionExploreAvoidFrontNear.h"
#include "ActionExploreNavigateNear.h"
#include "Aria.h"
#include "iostream"

int main(int argc, char **argv) {
    /* initalize robot  */
    Aria::init();
    ArArgumentParser argParser(&argc, argv);
    argParser.loadDefaultArguments();
    ArRobot robot;
    ArRobotConnector robotConnector(&argParser, &robot);
    ArLaserConnector laserConnector(&argParser, &robot, &robotConnector);

    if (!robotConnector.connectRobot()) {
        ArLog::log(ArLog::Terse, "Could not connect to the robot.");
        if (argParser.checkHelpAndWarnUnparsed()) {
            // -help not given, just exit.
            Aria::logOptions();
            Aria::exit(1);
            return 1;
        }
    }


    // Trigger argument parsing
    if (!Aria::parseArgs() || !argParser.checkHelpAndWarnUnparsed()) {
        Aria::logOptions();
        Aria::exit(1);
        return 1;
    }

    ArKeyHandler keyHandler;
    Aria::setKeyHandler(&keyHandler);
    robot.attachKeyHandler(&keyHandler);

    std::cout << "Navbot Enabled\n" << std::endl;

    ArSonarDevice sonar;
    robot.addRangeDevice(&sonar);

    robot.runAsync(true);

    robot.enableMotors();
    robot.comInt(ArCommands::SOUNDTOG, 0);

    ArActionStallRecover recover;
    ArActionBumpers bumpers;
    
    ActionExploreVelocity exploreVelocity(500, 500);
    ActionExploreAvoidFrontNear exploreAvoidFrontNear(1500);
    ActionExploreNavigateNear exploreNavigateNear(2000);
    
    robot.addAction(&recover, 100);
    robot.addAction(&bumpers, 75);
    robot.addAction(&exploreAvoidFrontNear, 50);
    robot.addAction(&exploreNavigateNear, 50);
    robot.addAction(&exploreVelocity, 30);
    robot.waitForRunExit();

    Aria::exit(0);
    return 0;
}
