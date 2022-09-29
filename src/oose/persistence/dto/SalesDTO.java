package oose.persistence.dto;

import java.sql.Date;

public class SalesDTO {
    int paymentId;
    String paymentPrice;
    String paymentContent;
    String paymentMethod;
    String paymentTime;
    Date paymentDate;
    Date startDate;
    Date endDate;

    int classCode;

    public SalesDTO() {}

    public SalesDTO(int classCode) {
        this.classCode = classCode;
    }

    public int getPaymentId() { return paymentId; }
    public void setPaymentId(int paymentId) { this.paymentId = paymentId; }

    public String getPaymentPrice() { return paymentPrice; }
    public void setPaymentPrice( String paymentPrice) { this.paymentPrice = paymentPrice; }

    public String getPaymentContent() { return paymentContent; }
    public void setPaymentContent( String paymentContent) { this.paymentContent = paymentContent; }

    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod( String paymentMethod) { this.paymentMethod = paymentMethod; }

    public String getPaymentTime() { return paymentTime; }
    public void setPaymentTime( String paymentTime) { this.paymentTime = paymentTime; }

    public Date getPaymentDate() { return paymentDate; }
    public void setPaymentDate( Date paymentDate) { this.paymentDate = paymentDate; }

    public Date getStartDate() { return startDate; }
    public void setStartDate(Date startDate) { this.startDate = startDate; }

    public Date getEndDate() { return endDate; }
    public void setEndDate(Date endDate) { this.endDate = endDate; }

    public int getClassCode() { return classCode; }
    public void setClassCode(int classCode) { this.classCode = classCode; }
}