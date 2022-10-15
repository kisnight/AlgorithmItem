package study.demo.recursive;

import java.util.ArrayList;
import java.util.List;

public class BuildProcTreeNode {
    Long nodeId = 0L;
    List<ProcTree> procRet = new ArrayList<>();

    public static void main(String[] args) {
        BuildProcTreeNode a = new BuildProcTreeNode();
        a.BuildProcTreeNodes();
    }

    private void BuildProcTreeNodes() {
        List<ProcTree> procTreeList = buildData();
        for(ProcTree procTreeItem : procTreeList) {
            buildTreeNode(procTreeItem, -1L);
        }
        System.out.println("build success.");
    }

    private void buildTreeNode(ProcTree procTree, Long callerId) {
        procTree.setCallerId(callerId);
        procTree.setNodeId(nodeId);
        nodeId ++;
        procRet.add(procTree);
        List<ProcTree> callees = procTree.getCallees();
        if(callees == null || callees.size() == 0) {
            return;
        }
        for(ProcTree procTreeItem : callees) {
            buildTreeNode(procTreeItem, procTree.getNodeId());
        }
    }

    private List<ProcTree> buildData() {
        List<ProcTree> procTreeList = new ArrayList<>();

        ProcTree procTree1_1 = new ProcTree("1.1");
        ProcTree procTree1_2 = new ProcTree("1.2");
        ProcTree procTree1 = new ProcTree("1");
        procTree1.getCallees().add(procTree1_1);
        procTree1.getCallees().add(procTree1_2);

        ProcTree procTree2_1 = new ProcTree("2.1");
        ProcTree procTree2_2 = new ProcTree("2.2");
        ProcTree procTree2 = new ProcTree("2");
        procTree2.getCallees().add(procTree2_1);
        procTree2.getCallees().add(procTree2_2);


        ProcTree procTree3_1 = new ProcTree("3.1");
        ProcTree procTree3_2 = new ProcTree("3.2");
        ProcTree procTree3 = new ProcTree("3");
        procTree3.getCallees().add(procTree3_1);
        procTree3.getCallees().add(procTree3_2);

        procTreeList.add(procTree1);
        procTreeList.add(procTree2);
        procTreeList.add(procTree3);

        return procTreeList;
    }


}
