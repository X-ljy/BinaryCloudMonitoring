package com.binary.servermonitor.entity;

/**
 * @author Wei Peng
 */
public class FireWallRule {
    private String id;
    private String name;
    private String direction;
    private String portStart;
    private String portEnd;
    private String protocol;
    private Integer priority;
    private boolean enabled;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getPortStart() {
        return portStart;
    }

    public void setPortStart(String portStart) {
        this.portStart = portStart;
    }

    public void setPortEnd(String portEnd) {
        this.portEnd = portEnd;
    }

    public String getPortEnd() {
        return portEnd;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "FireWallRule{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", direction='" + direction + '\'' +
                ", portStart=" + portStart +
                ", portEnd=" + portEnd +
                ", protocol='" + protocol + '\'' +
                ", priority=" + priority +
                ", enabled=" + enabled +
                '}';
    }
}
