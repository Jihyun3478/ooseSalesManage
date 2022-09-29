package oose.persistence.dto;

import java.util.Date;

public class ClassInformationDTO {
    int classCode;
    String className;
    int code;
    Date classTime;
    String facilityName;
    int tution;
    String classContent;

    public ClassInformationDTO() {}

    public ClassInformationDTO(String facilityName) {
        this.facilityName = facilityName;
    }

    public int getClassCode() { return classCode; }
    public void setClassCode(int classCode) { this.classCode = classCode; }

    public String getClassName() { return className; }
    public void setClassName(String className) { this.className = className; }

    public int getCode() { return code; }
    public void setCode(int code) { this.code = code; }

    public Date getClassTime() { return classTime; }
    public void setClassTime(Date classTime) { this.classTime = classTime; }

    public String getFacilityName() { return facilityName; }
    public void setFacilityName(String facilityName) { this.facilityName = facilityName; }

    public int getTution() { return tution; }
    public void setTution(int tution) { this.tution = tution; }

    public String getClassContent() { return classContent; }
    public void setClassContent(String classContent) { this.classContent = classContent; }
}
