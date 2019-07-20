package com.binary.servermonitor.data_api.image;

public class Image {
    private String Id;
    private String Name;
    private String Description;
    private String OsId;
    private String OsName;
    private boolean Shared;
    private String Owner;
    private String CreateTime;
    private String Use;
    private boolean HotUpgrade;
    private Integer Size;
    private String Status;
    private Integer InstanceNum;
    private String TemplateName;
    private String TemplateImageType;
    private boolean IsoDisk;
    private boolean Gpu;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getOsId() {
        return OsId;
    }

    public void setOsId(String osId) {
        OsId = osId;
    }

    public String getOsName() {
        return OsName;
    }

    public void setOsName(String osName) {
        OsName = osName;
    }

    public boolean isShared() {
        return Shared;
    }

    public void setShared(boolean shared) {
        Shared = shared;
    }

    public String getOwner() {
        return Owner;
    }

    public void setOwner(String owner) {
        Owner = owner;
    }

    public String getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(String createTime) {
        CreateTime = createTime;
    }

    public String getUse() {
        return Use;
    }

    public void setUse(String use) {
        Use = use;
    }

    public boolean isHotUpgrade() {
        return HotUpgrade;
    }

    public void setHotUpgrade(boolean hotUpgrade) {
        HotUpgrade = hotUpgrade;
    }

    public Integer getSize() {
        return Size;
    }

    public void setSize(Integer size) {
        Size = size;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public Integer getInstanceNum() {
        return InstanceNum;
    }

    public void setInstanceNum(Integer instanceNum) {
        InstanceNum = instanceNum;
    }

    public String getTemplateName() {
        return TemplateName;
    }

    public void setTemplateName(String templateName) {
        TemplateName = templateName;
    }

    public String getTemplateImageType() {
        return TemplateImageType;
    }

    public void setTemplateImageType(String templateImageType) {
        TemplateImageType = templateImageType;
    }

    public boolean isIsoDisk() {
        return IsoDisk;
    }

    public void setIsoDisk(boolean isoDisk) {
        IsoDisk = isoDisk;
    }

    public boolean isGpu() {
        return Gpu;
    }

    public void setGpu(boolean gpu) {
        Gpu = gpu;
    }

    @Override
    public String toString() {
        return "Image{" +
                "Id='" + Id + '\'' +
                ", Name='" + Name + '\'' +
                ", Description='" + Description + '\'' +
                ", OsId='" + OsId + '\'' +
                ", OsName='" + OsName + '\'' +
                ", Shared=" + Shared +
                ", Owner='" + Owner + '\'' +
                ", CreateTime='" + CreateTime + '\'' +
                ", Use='" + Use + '\'' +
                ", HotUpgrade=" + HotUpgrade +
                ", Size=" + Size +
                ", Status='" + Status + '\'' +
                ", InstanceNum=" + InstanceNum +
                ", TemplateName='" + TemplateName + '\'' +
                ", TemplateImageType='" + TemplateImageType + '\'' +
                ", IsoDisk=" + IsoDisk +
                ", Gpu=" + Gpu +
                '}';
    }
}
