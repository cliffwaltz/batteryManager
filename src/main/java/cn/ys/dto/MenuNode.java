package cn.ys.dto;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Map;

public class MenuNode implements Serializable {
    private Integer id;
    private String text;
    private String state;
    private boolean checked;
    private Map<String,Object> attributes;
    private MenuNode[] children;
    private Integer parentId;




    public MenuNode() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    public MenuNode[] getChildren() {
        return children;
    }

    public void setChildren(MenuNode[] children) {
        this.children = children;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return "MenuNode{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", state='" + state + '\'' +
                ", checked=" + checked +
                ", attributes=" + attributes +
                ", children=" + Arrays.toString(children) +
                ", parentId=" + parentId +
                '}';
    }
}
