package com.binary.servermonitor.entity;

import java.util.ArrayList;

/**
 * @author Wei Peng
 */
public class BindingSet {
    private String resourceId;
    private String resourceName;
    private String resourceType;
    private ArrayList<String> resourceEips = new ArrayList<String>();

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public ArrayList<String> getResourceEips() {
        return resourceEips;
    }

    public void setResourceEips(String resourceEips) {
        this.resourceEips.add(resourceEips);
    }

    @Override
    public String toString() {
        return "BindingSet{" +
                "resourceId='" + resourceId + '\'' +
                ", resourceName='" + resourceName + '\'' +
                ", resourceType='" + resourceType + '\'' +
                ", resourceEips=" + resourceEips +
                '}';
    }
}
