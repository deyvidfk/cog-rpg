/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cog.models;

import java.util.List;

/**
 *
 * @author dev-004
 */
public class AppConfigModel {

    private String gameVersion;
    private String gameHistory;

 
    private String gameName;
    
     private ResourceMessages[] resourceMessages;

    public String getGameVersion() {
        return gameVersion;
    }

    public String getGameHistory() {
        return gameHistory;
    }

    public String getGameName() {
        return gameName;
    }

    public ResourceMessages[] getResourceMessages() {
        return resourceMessages;
    }
    
    
  public class ResourceMessages{
         private String  key;
         private String text;

        public String getKey() {
            return key;
        }

        public String getText() {
            return text;
        }
    }
}
