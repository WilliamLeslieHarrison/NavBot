/*
Adept MobileRobots Robotics Interface for Applications (ARIA)
Copyright (C) 2004-2005 ActivMedia Robotics LLC
Copyright (C) 2006-2010 MobileRobots Inc.
Copyright (C) 2011-2015 Adept Technology, Inc.
Copyright (C) 2016-2018 Omron Adept Technologies, Inc.

     This program is free software; you can redistribute it and/or modify
     it under the terms of the GNU General Public License as published by
     the Free Software Foundation; either version 2 of the License, or
     (at your option) any later version.

     This program is distributed in the hope that it will be useful,
     but WITHOUT ANY WARRANTY; without even the implied warranty of
     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
     GNU General Public License for more details.

     You should have received a copy of the GNU General Public License
     along with this program; if not, write to the Free Software
     Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA

If you wish to redistribute ARIA under different terms, contact 
Adept MobileRobots for information about a commercial version of ARIA at 
robots@mobilerobots.com or 
Adept MobileRobots, 10 Columbia Drive, Amherst, NH 03031; +1-603-881-7960
*/
/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.8
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.mobilerobots.ArNetworking;
import com.mobilerobots.Aria.*;
public class ArServerModeIdle extends ArServerMode {
  private transient long swigCPtr;

  public ArServerModeIdle(long cPtr, boolean cMemoryOwn) {
    super(ArNetworkingJavaJNI.ArServerModeIdle_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  public static long getCPtr(ArServerModeIdle obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        ArNetworkingJavaJNI.delete_ArServerModeIdle(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public ArServerModeIdle(ArServerBase server, ArRobot robot) {
    this(ArNetworkingJavaJNI.new_ArServerModeIdle(ArServerBase.getCPtr(server), server, ArRobot.getCPtr(robot), robot), true);
  }

  public void activate() {
    ArNetworkingJavaJNI.ArServerModeIdle_activate(swigCPtr, this);
  }

  public void deactivate() {
    ArNetworkingJavaJNI.ArServerModeIdle_deactivate(swigCPtr, this);
  }

  public void userTask() {
    ArNetworkingJavaJNI.ArServerModeIdle_userTask(swigCPtr, this);
  }

  public void setModeInterrupted(ArServerMode modeInterrupted) {
    ArNetworkingJavaJNI.ArServerModeIdle_setModeInterrupted(swigCPtr, this, ArServerMode.getCPtr(modeInterrupted), modeInterrupted);
  }

  public ArServerMode getModeInterrupted() {
    long cPtr = ArNetworkingJavaJNI.ArServerModeIdle_getModeInterrupted(swigCPtr, this);
    return (cPtr == 0) ? null : new ArServerMode(cPtr, false);
  }

  public ArActionGroup getActionGroup() {
    long cPtr = ArNetworkingJavaJNI.ArServerModeIdle_getActionGroup(swigCPtr, this);
    return (cPtr == 0) ? null : new ArActionGroup(cPtr, false);
  }

  public void addToConfig(ArConfig config, String section) {
    ArNetworkingJavaJNI.ArServerModeIdle_addToConfig__SWIG_0(swigCPtr, this, ArConfig.getCPtr(config), config, section);
  }

  public void addToConfig(ArConfig config) {
    ArNetworkingJavaJNI.ArServerModeIdle_addToConfig__SWIG_1(swigCPtr, this, ArConfig.getCPtr(config), config);
  }

  public void setUseLocationDependentDevices(boolean useLocationDependentDevices, boolean internal) {
    ArNetworkingJavaJNI.ArServerModeIdle_setUseLocationDependentDevices__SWIG_0(swigCPtr, this, useLocationDependentDevices, internal);
  }

  public void setUseLocationDependentDevices(boolean useLocationDependentDevices) {
    ArNetworkingJavaJNI.ArServerModeIdle_setUseLocationDependentDevices__SWIG_1(swigCPtr, this, useLocationDependentDevices);
  }

  public boolean getUseLocationDependentDevices() {
    return ArNetworkingJavaJNI.ArServerModeIdle_getUseLocationDependentDevices(swigCPtr, this);
  }

}
