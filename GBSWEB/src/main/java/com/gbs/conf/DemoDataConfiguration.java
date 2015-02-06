/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.gbs.conf;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.ResourcePropertySource;

import com.gbs.dao.GroupDao;
import com.gbs.dao.UserDao;
import com.gbs.entity.GroupInfo;
import com.gbs.entity.UserInfo;



/**
 * @author HuangLiPing
 */
@Configuration
public class DemoDataConfiguration {
  
  //protected static final Logger LOGGER = LoggerFactory.getLogger(DemoDataConfiguration.class);
  
  //@Autowired
 // private Environment environment;
  
  //@Autowired
  private UserDao userDao;
  
  //@Autowired
  private GroupDao groupDao;
  
  @PostConstruct
  public void init() {
	  ResourcePropertySource propertySource = null;
	try {
		propertySource = new ResourcePropertySource("resource", "classpath:grtwf.properties");
		if(propertySource != null) {
			String property = (String)propertySource.getProperty("create.demo.users");
			//LOGGER.info("####property = " + property);
			
		    if (Boolean.valueOf(property)) {
		      //LOGGER.info("####Initializing demo groups");
		      //groupDao.deleteAll();
		      //initDemoGroups();
		      //LOGGER.info("####Initializing demo users");
		      //userDao.deleteAll();
		      initDemoUsers();
		    }
		}
	    
	} catch (IOException e) {
		e.printStackTrace();
	}
		
  }
  
  protected void initDemoGroups() {
    String[] assignmentGroups = new String[] {"management", "sales", "marketing", "engineering"};
    for (String groupId : assignmentGroups) {
      createGroup(groupId, "assignment");
    }
    
    String[] securityGroups = new String[] {"user", "admin"}; 
    for (String groupId : securityGroups) {
      createGroup(groupId, "security-role");
    }
    
    String[] customerGroups = new String[] {"checker", "auditor", "approver"}; 
    for (String groupId : customerGroups) {
      createGroup(groupId, "assignment");
    }
  }
  
  protected void createGroup(String groupId, String type) {
    
      GroupInfo newGroup = new GroupInfo();
      newGroup.setName(groupId.substring(0, 1).toUpperCase() + groupId.substring(1));
      newGroup.setType(type);
      newGroup.setCreateUser("1");
      newGroup.setCreateDate(new Date());
      //groupDao.save(newGroup);

  }

  protected void initDemoUsers() {
	  List<UserInfo> users = new ArrayList<UserInfo>();
	  
	 UserInfo user = createUser("kermit", "Kermit", "The Frog", "kermit", "kermit@activiti.org", 
	            "org/activiti/explorer/images/kermit.jpg",
	            Arrays.asList("user"),
	            Arrays.asList("birthDate", "10-10-1955", "jobTitle", "Muppet", "location", "Hollywoord",
	                          "phone", "+123456789", "twitterName", "alfresco", "skype", "activiti_kermit_frog"));
	 users.add(user);
//	 users.add(createUser("gonzo", "Gonzo", "The Great", "gonzo", "gonzo@activiti.org", 
//            "org/activiti/explorer/images/gonzo.jpg",
//            Arrays.asList("management", "sales", "marketing", "user"),
//            null));
//	 users.add(createUser("fozzie", "Fozzie", "Bear", "fozzie", "fozzie@activiti.org", 
//            "org/activiti/explorer/images/fozzie.jpg",
//            Arrays.asList("marketing", "engineering"),
//            null));

	 users.add(createUser("checker1", "checker1", "The Great", "1", "gonzo@activiti.org", 
            "org/activiti/explorer/images/gonzo.jpg",
            Arrays.asList("user", "checker"),
            null));
    
//	 users.add(createUser("checker2", "checker2", "The Great", "1", "gonzo@activiti.org", 
//            "org/activiti/explorer/images/kermit.jpg",
//            Arrays.asList("user", "checker"),
//            null));
//    
	 users.add(createUser("auditor1", "auditor1", "The Great", "1", "gonzo@activiti.org", 
            "org/activiti/explorer/images/gonzo.jpg",
            Arrays.asList("user", "auditor"),
            null));
    
//	 users.add(createUser("auditor2", "auditor2", "The Great", "1", "gonzo@activiti.org", 
//            "org/activiti/explorer/images/gonzo.jpg",
//            Arrays.asList("auditor"),
//            null));
    
	 users.add(createUser("approver1", "approver1", "Bear", "1", "bigman@activiti.org", 
            "org/activiti/explorer/images/fozzie.jpg",
            Arrays.asList("approver"),
            null));
    
	 users.add(createUser("admin", "admin", "The Frog", "admin", "admin@activiti.org", 
            "org/activiti/explorer/images/kermit.jpg",
            Arrays.asList("admin"),
            Arrays.asList("birthDate", "10-10-1955", "jobTitle", "Muppet", "location", "Hollywoord",
                          "phone", "+123456789", "twitterName", "alfresco", "skype", "activiti_kermit_frog")));
	 
	 //userDao.save(users);
  }
  
  protected UserInfo createUser(String userId, String firstName, String lastName, String password, 
          String email, String imageResource, List<String> groups, List<String> userInfo) {

      UserInfo user = new UserInfo();
      user.setUserId(userId);
      //user.setName(firstName + lastName);
      user.setPwd(password);
      user.setEmail(email);
      user.setCreateDate(new Date());
      user.setCreateUser("1");
      
      if (groups != null) {
    	  Set<GroupInfo> groupInfos = new HashSet<GroupInfo>();
        for (String groupId : groups) {
          GroupInfo groupInfo = groupDao.findByName(groupId);
          if(groupInfo == null) {
        	  groupInfo = new GroupInfo();
        	  groupInfo.setName(groupId);
        	  groupInfo.setType("security-role");
        	  groupInfo.setCreateUser("1");
        	  groupInfo.setCreateDate(new Date());
          }
          groupInfos.add(groupInfo);
        }
        user.setGroups(groupInfos);
      }
      
      //userDao.save(user);
      
      return user;
    
  }
  
}
