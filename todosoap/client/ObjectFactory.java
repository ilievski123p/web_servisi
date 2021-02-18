package client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the client package. 
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

    private final static QName _GetTasksByUser_QNAME = new QName("http://todo/", "getTasksByUser");
    private final static QName _GetFreeTasks_QNAME = new QName("http://todo/", "getFreeTasks");
    private final static QName _GetTasksByStatus_QNAME = new QName("http://todo/", "getTasksByStatus");
    private final static QName _GetTasksByUserResponse_QNAME = new QName("http://todo/", "getTasksByUserResponse");
    private final static QName _GetAllTasks_QNAME = new QName("http://todo/", "getAllTasks");
    private final static QName _GetAllUsers_QNAME = new QName("http://todo/", "getAllUsers");
    private final static QName _GetAllUsersResponse_QNAME = new QName("http://todo/", "getAllUsersResponse");
    private final static QName _GetTasksByDate_QNAME = new QName("http://todo/", "getTasksByDate");
    private final static QName _GetTasksByStatusResponse_QNAME = new QName("http://todo/", "getTasksByStatusResponse");
    private final static QName _GetTasksByDateResponse_QNAME = new QName("http://todo/", "getTasksByDateResponse");
    private final static QName _GetAllTasksResponse_QNAME = new QName("http://todo/", "getAllTasksResponse");
    private final static QName _GetFreeTasksResponse_QNAME = new QName("http://todo/", "getFreeTasksResponse");
    private final static QName _GetTasksByPriority_QNAME = new QName("http://todo/", "getTasksByPriority");
    private final static QName _GetTasksByPriorityResponse_QNAME = new QName("http://todo/", "getTasksByPriorityResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetAllTasks }
     * 
     */
    public GetAllTasks createGetAllTasks() {
        return new GetAllTasks();
    }

    /**
     * Create an instance of {@link GetAllUsers }
     * 
     */
    public GetAllUsers createGetAllUsers() {
        return new GetAllUsers();
    }

    /**
     * Create an instance of {@link GetAllUsersResponse }
     * 
     */
    public GetAllUsersResponse createGetAllUsersResponse() {
        return new GetAllUsersResponse();
    }

    /**
     * Create an instance of {@link GetTasksByUser }
     * 
     */
    public GetTasksByUser createGetTasksByUser() {
        return new GetTasksByUser();
    }

    /**
     * Create an instance of {@link GetTasksByStatus }
     * 
     */
    public GetTasksByStatus createGetTasksByStatus() {
        return new GetTasksByStatus();
    }

    /**
     * Create an instance of {@link GetTasksByUserResponse }
     * 
     */
    public GetTasksByUserResponse createGetTasksByUserResponse() {
        return new GetTasksByUserResponse();
    }

    /**
     * Create an instance of {@link GetAllTasksResponse }
     * 
     */
    public GetAllTasksResponse createGetAllTasksResponse() {
        return new GetAllTasksResponse();
    }

    /**
     * Create an instance of {@link GetTasksByDate }
     * 
     */
    public GetTasksByDate createGetTasksByDate() {
        return new GetTasksByDate();
    }

    /**
     * Create an instance of {@link GetTasksByStatusResponse }
     * 
     */
    public GetTasksByStatusResponse createGetTasksByStatusResponse() {
        return new GetTasksByStatusResponse();
    }

    /**
     * Create an instance of {@link GetTasksByDateResponse }
     * 
     */
    public GetTasksByDateResponse createGetTasksByDateResponse() {
        return new GetTasksByDateResponse();
    }
        /**
     * Create an instance of {@link GetTasksByDateResponse }
     * 
     */
    public GetTasksByPriorityResponse createGetTasksByPriorityResponse() {
        return new GetTasksByPriorityResponse();
    }
        /**
     * Create an instance of {@link GetTasksByDateResponse }
     * 
     */
    public GetTasksByPriority createGetTasksByPriority() {
        return new GetTasksByPriority();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTasksByUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://todo/", name = "getTasksByUser")
    public JAXBElement<GetTasksByUser> createGetTasksByUser(GetTasksByUser value) {
        return new JAXBElement<GetTasksByUser>(_GetTasksByUser_QNAME, GetTasksByUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTasksByStatus }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://todo/", name = "getTasksByStatus")
    public JAXBElement<GetTasksByStatus> createGetTasksByStatus(GetTasksByStatus value) {
        return new JAXBElement<GetTasksByStatus>(_GetTasksByStatus_QNAME, GetTasksByStatus.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTasksByUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://todo/", name = "getTasksByUserResponse")
    public JAXBElement<GetTasksByUserResponse> createGetTasksByUserResponse(GetTasksByUserResponse value) {
        return new JAXBElement<GetTasksByUserResponse>(_GetTasksByUserResponse_QNAME, GetTasksByUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllTasks }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://todo/", name = "getAllTasks")
    public JAXBElement<GetAllTasks> createGetAllTasks(GetAllTasks value) {
        return new JAXBElement<GetAllTasks>(_GetAllTasks_QNAME, GetAllTasks.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllUsers }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://todo/", name = "getAllUsers")
    public JAXBElement<GetAllUsers> createGetAllUsers(GetAllUsers value) {
        return new JAXBElement<GetAllUsers>(_GetAllUsers_QNAME, GetAllUsers.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllUsersResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://todo/", name = "getAllUsersResponse")
    public JAXBElement<GetAllUsersResponse> createGetAllUsersResponse(GetAllUsersResponse value) {
        return new JAXBElement<GetAllUsersResponse>(_GetAllUsersResponse_QNAME, GetAllUsersResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTasksByDate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://todo/", name = "getTasksByDate")
    public JAXBElement<GetTasksByDate> createGetTasksByDate(GetTasksByDate value) {
        return new JAXBElement<GetTasksByDate>(_GetTasksByDate_QNAME, GetTasksByDate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTasksByStatusResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://todo/", name = "getTasksByStatusResponse")
    public JAXBElement<GetTasksByStatusResponse> createGetTasksByStatusResponse(GetTasksByStatusResponse value) {
        return new JAXBElement<GetTasksByStatusResponse>(_GetTasksByStatusResponse_QNAME, GetTasksByStatusResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTasksByDateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://todo/", name = "getTasksByDateResponse")
    public JAXBElement<GetTasksByDateResponse> createGetTasksByDateResponse(GetTasksByDateResponse value) {
        return new JAXBElement<GetTasksByDateResponse>(_GetTasksByDateResponse_QNAME, GetTasksByDateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllTasksResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://todo/", name = "getAllTasksResponse")
    public JAXBElement<GetAllTasksResponse> createGetAllTasksResponse(GetAllTasksResponse value) {
        return new JAXBElement<GetAllTasksResponse>(_GetAllTasksResponse_QNAME, GetAllTasksResponse.class, null, value);
    }

     /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTasksByPriorityResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://todo/", name = "getTasksByPriorityResponse")
    public JAXBElement<GetTasksByPriorityResponse> createGetTasksByPriorityResponse(GetTasksByPriorityResponse value) {
        return new JAXBElement<GetTasksByPriorityResponse>(_GetTasksByPriorityResponse_QNAME, GetTasksByPriorityResponse.class, null, value);
    }
     
    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTasksByPriority }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://todo/", name = "getTasksByPriority")
    public JAXBElement<GetTasksByPriority> createGetTasksByPriority(GetTasksByPriority value) {
        return new JAXBElement<GetTasksByPriority>(_GetTasksByPriority_QNAME, GetTasksByPriority.class, null, value);
    }

}
