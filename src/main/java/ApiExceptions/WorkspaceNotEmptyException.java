/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ApiExceptions;

import java.util.UUID;
/**
 *
 * @author Student
 */
public class WorkspaceNotEmptyException extends RuntimeException{
    
    public WorkspaceNotEmptyException (UUID workspaceID) {
        super("workspace" + workspaceID + " is not empty." );
    }
}
