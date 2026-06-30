/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

/**
 *
 * @author Student
 */


import java.util.HashMap;
import java.util.Map;

import models.MLWorkspace;
import models.MachineLearningModel;

public class DataStore {

    public static Map<String, MLWorkspace> workspaces = new HashMap<>();

    public static Map<String, MachineLearningModel> models = new HashMap<>();

}

