
package com.uaf.grtwf.webservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.uaf.grtwf.webservice package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _StartProcess_QNAME = new QName("http://webservice.grtwf.uaf.com/", "startProcess");
    private final static QName _ClaimTaskResponse_QNAME = new QName("http://webservice.grtwf.uaf.com/", "claimTaskResponse");
    private final static QName _GetVariablesResponse_QNAME = new QName("http://webservice.grtwf.uaf.com/", "getVariablesResponse");
    private final static QName _FindTodoTasks_QNAME = new QName("http://webservice.grtwf.uaf.com/", "findTodoTasks");
    private final static QName _StartProcessResponse_QNAME = new QName("http://webservice.grtwf.uaf.com/", "startProcessResponse");
    private final static QName _CompleteTask_QNAME = new QName("http://webservice.grtwf.uaf.com/", "completeTask");
    private final static QName _FindTodoTasksResponse_QNAME = new QName("http://webservice.grtwf.uaf.com/", "findTodoTasksResponse");
    private final static QName _ClaimTask_QNAME = new QName("http://webservice.grtwf.uaf.com/", "claimTask");
    private final static QName _CompleteTaskResponse_QNAME = new QName("http://webservice.grtwf.uaf.com/", "completeTaskResponse");
    private final static QName _GetVariables_QNAME = new QName("http://webservice.grtwf.uaf.com/", "getVariables");
    private final static QName _Exception_QNAME = new QName("http://webservice.grtwf.uaf.com/", "Exception");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.uaf.grtwf.webservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CompleteTaskResponse }
     * 
     */
    public CompleteTaskResponse createCompleteTaskResponse() {
        return new CompleteTaskResponse();
    }

    /**
     * Create an instance of {@link ClaimTask }
     * 
     */
    public ClaimTask createClaimTask() {
        return new ClaimTask();
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link GetVariables }
     * 
     */
    public GetVariables createGetVariables() {
        return new GetVariables();
    }

    /**
     * Create an instance of {@link FindTodoTasksResponse }
     * 
     */
    public FindTodoTasksResponse createFindTodoTasksResponse() {
        return new FindTodoTasksResponse();
    }

    /**
     * Create an instance of {@link CompleteTask }
     * 
     */
    public CompleteTask createCompleteTask() {
        return new CompleteTask();
    }

    /**
     * Create an instance of {@link StartProcess }
     * 
     */
    public StartProcess createStartProcess() {
        return new StartProcess();
    }

    /**
     * Create an instance of {@link ClaimTaskResponse }
     * 
     */
    public ClaimTaskResponse createClaimTaskResponse() {
        return new ClaimTaskResponse();
    }

    /**
     * Create an instance of {@link FindTodoTasks }
     * 
     */
    public FindTodoTasks createFindTodoTasks() {
        return new FindTodoTasks();
    }

    /**
     * Create an instance of {@link StartProcessResponse }
     * 
     */
    public StartProcessResponse createStartProcessResponse() {
        return new StartProcessResponse();
    }

    /**
     * Create an instance of {@link GetVariablesResponse }
     * 
     */
    public GetVariablesResponse createGetVariablesResponse() {
        return new GetVariablesResponse();
    }

    /**
     * Create an instance of {@link MapEntity }
     * 
     */
    public MapEntity createMapEntity() {
        return new MapEntity();
    }

    /**
     * Create an instance of {@link TaskDto }
     * 
     */
    public TaskDto createTaskDto() {
        return new TaskDto();
    }

    /**
     * Create an instance of {@link MapEntityArray }
     * 
     */
    public MapEntityArray createMapEntityArray() {
        return new MapEntityArray();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StartProcess }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.grtwf.uaf.com/", name = "startProcess")
    public JAXBElement<StartProcess> createStartProcess(StartProcess value) {
        return new JAXBElement<StartProcess>(_StartProcess_QNAME, StartProcess.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClaimTaskResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.grtwf.uaf.com/", name = "claimTaskResponse")
    public JAXBElement<ClaimTaskResponse> createClaimTaskResponse(ClaimTaskResponse value) {
        return new JAXBElement<ClaimTaskResponse>(_ClaimTaskResponse_QNAME, ClaimTaskResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetVariablesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.grtwf.uaf.com/", name = "getVariablesResponse")
    public JAXBElement<GetVariablesResponse> createGetVariablesResponse(GetVariablesResponse value) {
        return new JAXBElement<GetVariablesResponse>(_GetVariablesResponse_QNAME, GetVariablesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindTodoTasks }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.grtwf.uaf.com/", name = "findTodoTasks")
    public JAXBElement<FindTodoTasks> createFindTodoTasks(FindTodoTasks value) {
        return new JAXBElement<FindTodoTasks>(_FindTodoTasks_QNAME, FindTodoTasks.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StartProcessResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.grtwf.uaf.com/", name = "startProcessResponse")
    public JAXBElement<StartProcessResponse> createStartProcessResponse(StartProcessResponse value) {
        return new JAXBElement<StartProcessResponse>(_StartProcessResponse_QNAME, StartProcessResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CompleteTask }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.grtwf.uaf.com/", name = "completeTask")
    public JAXBElement<CompleteTask> createCompleteTask(CompleteTask value) {
        return new JAXBElement<CompleteTask>(_CompleteTask_QNAME, CompleteTask.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindTodoTasksResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.grtwf.uaf.com/", name = "findTodoTasksResponse")
    public JAXBElement<FindTodoTasksResponse> createFindTodoTasksResponse(FindTodoTasksResponse value) {
        return new JAXBElement<FindTodoTasksResponse>(_FindTodoTasksResponse_QNAME, FindTodoTasksResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClaimTask }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.grtwf.uaf.com/", name = "claimTask")
    public JAXBElement<ClaimTask> createClaimTask(ClaimTask value) {
        return new JAXBElement<ClaimTask>(_ClaimTask_QNAME, ClaimTask.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CompleteTaskResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.grtwf.uaf.com/", name = "completeTaskResponse")
    public JAXBElement<CompleteTaskResponse> createCompleteTaskResponse(CompleteTaskResponse value) {
        return new JAXBElement<CompleteTaskResponse>(_CompleteTaskResponse_QNAME, CompleteTaskResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetVariables }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.grtwf.uaf.com/", name = "getVariables")
    public JAXBElement<GetVariables> createGetVariables(GetVariables value) {
        return new JAXBElement<GetVariables>(_GetVariables_QNAME, GetVariables.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.grtwf.uaf.com/", name = "Exception")
    public JAXBElement<Exception> createException(Exception value) {
        return new JAXBElement<Exception>(_Exception_QNAME, Exception.class, null, value);
    }

}
