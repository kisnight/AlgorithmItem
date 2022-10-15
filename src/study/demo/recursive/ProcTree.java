package study.demo.recursive;




import java.util.ArrayList;
import java.util.List;

public class ProcTree {
    private Long id;
    private Long callerId;
    private Long nodeId;
    private String name;
    List<ProcTree> callees = new ArrayList<>();

    public ProcTree(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCallerId() {
        return callerId;
    }

    public void setCallerId(Long callerId) {
        this.callerId = callerId;
    }

    public Long getNodeId() {
        return nodeId;
    }

    public void setNodeId(Long nodeId) {
        this.nodeId = nodeId;
    }

    public List<ProcTree> getCallees() {
        return callees;
    }

    public void setCallees(List<ProcTree> callees) {
        this.callees = callees;
    }
}
