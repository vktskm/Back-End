package com.example.Spring_1;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ AltroAltroTest.class, AltroTest.class, UserTest.class })
public class AllUserTests {

}
