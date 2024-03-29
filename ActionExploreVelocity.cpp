#include "ActionExploreVelocity.h"

ActionExploreVelocity::ActionExploreVelocity(double maxSpeed, double stopDistance):
    ArAction ("exploreVelocity"),
    mySonar(NULL),
    myMaxSpeed(maxSpeed),
    myStopDistance(stopDistance)
{
    setNextArgument(ArArg("maximumSpeedExploreVelocity", &myMaxSpeed, "maximum speed while exploring"));
    setNextArgument(ArArg("stopDistanceExploreVelocity", &myStopDistance, "minimum distance to stop"));
}

void ActionExploreVelocity::setRobot(ArRobot *robot) {
    robot->lock();
    ArAction::setRobot(robot);
    robot->unlock();
    mySonar = robot->findRangeDevice("sonar");
    if (mySonar == NULL) {
        ArLog::log(ArLog::Terse, "ActionExploreVelocity: setRobot: Warning: found no sonar, deactivating.");
        deactivate();
    }
}

ArActionDesired *ActionExploreVelocity::fire(ArActionDesired currentDesired) {
    myDesired.reset();
    if (mySonar == NULL) {
        deactivate();
        return NULL;
    }
    // get the range of the sonar
    mySonar->lockDevice();
    range = mySonar->currentReadingPolar(-21, 21) - myRobot->getRobotRadius();
    mySonar->unlockDevice();
    // if the range is greater than the stop distance, find some speed to go
    if (range > myStopDistance) {
        myDesired.setVel(myMaxSpeed);
    } else {
        myDesired.setVel(myMaxSpeed*(range/myStopDistance));
    }
    // return a pointer to the actionDesired to the resolver to make our request
    return &myDesired;
}

