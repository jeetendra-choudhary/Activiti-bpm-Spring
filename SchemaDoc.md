##### POST URL - http://192.168.0.36:8080/activiti-rest/service/repository/deployments


{
  "id": "40",
  "name": "OfferProcess.bpmn",
  "deploymentTime": "2016-06-03T11:27:55.205+05:30",
  "category": null,
  "url": "http://192.168.0.36:8080/activiti-rest/service/repository/deployments/40",
  "tenantId": ""
}

----------

#### Start Process 

##### POST URL - http://192.168.0.36:8080/activiti-rest/service/runtime/process-instances
**Method Type** - POST 

**Payload** -

`{
    "processDefinitionKey":"LAP_Process", 
        "variables":[ 
            {"name":"REQ_ID","value":"123"}, 
            {"name":"REQ_DATE","value":"10-06-2016 11:11"}, 
            {"name":"TO_DATE","value":"15-06-2016 11:11"}, 
            {"name":"FROM_DATE","value":"18-06-2016 11:11"} 
        ] 
}` 


**Response** - 

`{
  "id": "52",
  "url": "http://192.168.0.36:8080/activiti-rest/service/runtime/process-instances/52",
  "businessKey": null,
  "suspended": false,
  "ended": false,
  "processDefinitionId": "LAP_Process:2:51",
  "processDefinitionUrl": "http://192.168.0.36:8080/activiti-rest/service/repository/process-definitions/LAP_Process:2:51",
  "activityId": "Review_Form",
  "variables": [],
  "tenantId": "",
  "completed": false
}`

------

#### Get Process Information - 
##### URL - http://192.168.0.36:8080/activiti-rest/service/runtime/process-instances?id=44&includeProcessVariables=true
**Method Type** GET

**Response** -

`{
  "data": [
    {
      "id": "44",
      "url": "http://192.168.0.36:8080/activiti-rest/service/runtime/process-instances/44",
      "businessKey": null,
      "suspended": false,
      "ended": false,
      "processDefinitionId": "LAP_Process:1:43",
      "processDefinitionUrl": "http://192.168.0.36:8080/activiti-rest/service/repository/process-definitions/LAP_Process:1:43",
      "activityId": "Review_Form",
      "variables": [
        {
          "name": "Kermit",
          "type": "string",
          "value": "kermit",
          "scope": "local"
        },
        {
          "name": "FROM_DATE",
          "type": "string",
          "value": "18-06-2016 11:11",
          "scope": "local"
        },
        {
          "name": "REQ_ID",
          "type": "string",
          "value": "123",
          "scope": "local"
        },
        {
          "name": "TO_DATE",
          "type": "string",
          "value": "15-06-2016 11:11",
          "scope": "local"
        },
        {
          "name": "REQ_DATE",
          "type": "string",
          "value": "10-06-2016 11:11",
          "scope": "local"
        }
      ],
      "tenantId": "",
      "completed": false
    }
  ],
  "total": 1,
  "start": 0,
  "sort": "id",
  "order": "asc",
  "size": 1
}`

------------


#### Get List of all Active process Instance - 
##### URL - http://192.168.0.36:8080/activiti-rest/service/runtime/process-instances
**Method Type** GET

**Response** - 

`{
  "data": [
    {
      "id": "44",
      "url": "http://192.168.0.36:8080/activiti-rest/service/runtime/process-instances/44",
      "businessKey": null,
      "suspended": false,
      "ended": false,
      "processDefinitionId": "LAP_Process:1:43",
      "processDefinitionUrl": "http://192.168.0.36:8080/activiti-rest/service/repository/process-definitions/LAP_Process:1:43",
      "activityId": "Review_Form",
      "variables": [],
      "tenantId": "",
      "completed": false
    }
  ],
  "total": 1,
  "start": 0,
  "sort": "id",
  "order": "asc",
  "size": 1
}`

------------

#### Get Pending Task for Process - 
##### GET URL - http://192.168.0.36:8080/activiti-rest/service/runtime/tasks?processInstanceId=44
**Method Type** GET

**Response** - 

`{
  "data": [
    {
      "id": "58",
      "url": "http://192.168.0.36:8080/activiti-rest/service/runtime/tasks/58",
      "owner": null,
      "assignee": "Kermit",
      "delegationState": null,
      "name": "Leave Review Form",
      "description": "Review Leave Request Form",
      "createTime": "2016-06-06T10:32:52.851+05:30",
      "dueDate": null,
      "priority": 1,
      "suspended": false,
      "taskDefinitionKey": "Review_Form",
      "tenantId": "",
      "category": null,
      "formKey": "REV_FORM",
      "parentTaskId": null,
      "parentTaskUrl": null,
      "executionId": "44",
      "executionUrl": "http://192.168.0.36:8080/activiti-rest/service/runtime/executions/44",
      "processInstanceId": "44",
      "processInstanceUrl": "http://192.168.0.36:8080/activiti-rest/service/runtime/process-instances/44",
      "processDefinitionId": "LAP_Process:1:43",
      "processDefinitionUrl": "http://192.168.0.36:8080/activiti-rest/service/repository/process-definitions/LAP_Process:1:43",
      "variables": []
    }
  ],
  "total": 1,
  "start": 0,
  "sort": "id",
  "order": "asc",
  "size": 1
}`

---------

#### Update Task - 
##### PUT URL - http://192.168.0.36:8080/activiti-rest/service/runtime/tasks/58
**Method Type** PUT

**Request Body** - 

`{
  "assignee" : "Jeetendra",
  "delegationState" : "resolved",
  "description" : "New task description",
  "dueDate" : "2016-06-07T13:06:02.438+02:00",
  "name" : "New task name",
  "owner" : "kermit",
  "priority" : 20
}`

**Response** - 

  `{
    "id": "58",
    "url": "http://192.168.0.36:8080/activiti-rest/service/runtime/tasks/58",
    "owner": "kermit",
    "assignee": "Jeetendra",
    "delegationState": "resolved",
    "name": "New task name",
    "description": "New task description",
    "createTime": "2016-06-06T10:32:52.851+05:30",
    "dueDate": "2016-06-07T16:36:02.438+05:30",
    "priority": 20,
    "suspended": false,
    "taskDefinitionKey": "Review_Form",
    "tenantId": "",
    "category": null,
    "formKey": "REV_FORM",
    "parentTaskId": null,
    "parentTaskUrl": null,
    "executionId": "44",
    "executionUrl": "http://192.168.0.36:8080/activiti-rest/service/runtime/executions/44",
    "processInstanceId": "44",
    "processInstanceUrl": "http://192.168.0.36:8080/activiti-rest/service/runtime/process-instances/44",
    "processDefinitionId": "LAP_Process:1:43",
    "processDefinitionUrl": "http://192.168.0.36:8080/activiti-rest/service/repository/process-definitions/LAP_Process:1:43",
    "variables": []
  }`
---------

####Claim Task - 
##### URL - http://192.168.0.36:8080/activiti-rest/service/runtime/tasks/58
**Method Type** POST

**Request** - 

`{
  "action" : "claim",
  "assignee" : "Jeetendra"
}`

**Response** - 

`none`

--------

#### Complete Task - 
##### URL - - http://192.168.0.36:8080/activiti-rest/service/runtime/tasks/58
**Method Type** POST

**Request** - 

`{
  "action" : "complete",
  "assignee" : "Jeetendra"
}`

**Response** - 

`None`

--------

#### Delegate Task - 
##### URL - http://192.168.0.36:8080/activiti-rest/service/runtime/tasks/63
**Method Type** POST

**Request** - 

`{
  "action" : "delegate",
  "assignee" : "kermit"
}`

--------

#### Resolve Task - 
##### URL - http://192.168.0.36:8080/activiti-rest/service/runtime/tasks/63
** Method Type** POST

**Request** - 

`{
  "action" : "resolve"
}`

**Response** - 

`None`

---------
