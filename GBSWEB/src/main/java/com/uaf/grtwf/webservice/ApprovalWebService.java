package com.uaf.grtwf.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.0.3
 * 2015-02-05T12:37:13.660+08:00
 * Generated source version: 3.0.3
 * 
 */
@WebService(targetNamespace = "http://webservice.grtwf.uaf.com/", name = "ApprovalWebService")
@XmlSeeAlso({ObjectFactory.class})
public interface ApprovalWebService {

    @RequestWrapper(localName = "claimTask", targetNamespace = "http://webservice.grtwf.uaf.com/", className = "com.uaf.grtwf.webservice.ClaimTask")
    @WebMethod
    @ResponseWrapper(localName = "claimTaskResponse", targetNamespace = "http://webservice.grtwf.uaf.com/", className = "com.uaf.grtwf.webservice.ClaimTaskResponse")
    public void claimTask(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        java.lang.String arg1
    ) throws Exception_Exception;

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "getVariables", targetNamespace = "http://webservice.grtwf.uaf.com/", className = "com.uaf.grtwf.webservice.GetVariables")
    @WebMethod
    @ResponseWrapper(localName = "getVariablesResponse", targetNamespace = "http://webservice.grtwf.uaf.com/", className = "com.uaf.grtwf.webservice.GetVariablesResponse")
    public com.uaf.grtwf.webservice.MapEntityArray getVariables(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    ) throws Exception_Exception;

    @RequestWrapper(localName = "completeTask", targetNamespace = "http://webservice.grtwf.uaf.com/", className = "com.uaf.grtwf.webservice.CompleteTask")
    @WebMethod
    @ResponseWrapper(localName = "completeTaskResponse", targetNamespace = "http://webservice.grtwf.uaf.com/", className = "com.uaf.grtwf.webservice.CompleteTaskResponse")
    public void completeTask(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        java.lang.String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        com.uaf.grtwf.webservice.MapEntityArray arg2
    ) throws Exception_Exception;

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "startProcess", targetNamespace = "http://webservice.grtwf.uaf.com/", className = "com.uaf.grtwf.webservice.StartProcess")
    @WebMethod
    @ResponseWrapper(localName = "startProcessResponse", targetNamespace = "http://webservice.grtwf.uaf.com/", className = "com.uaf.grtwf.webservice.StartProcessResponse")
    public java.lang.String startProcess(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        java.lang.String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        com.uaf.grtwf.webservice.MapEntityArray arg2
    ) throws Exception_Exception;

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "findTodoTasks", targetNamespace = "http://webservice.grtwf.uaf.com/", className = "com.uaf.grtwf.webservice.FindTodoTasks")
    @WebMethod
    @ResponseWrapper(localName = "findTodoTasksResponse", targetNamespace = "http://webservice.grtwf.uaf.com/", className = "com.uaf.grtwf.webservice.FindTodoTasksResponse")
    public java.util.List<com.uaf.grtwf.webservice.TaskDto> findTodoTasks(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        java.lang.String arg1
    ) throws Exception_Exception;
}