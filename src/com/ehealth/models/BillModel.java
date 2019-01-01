/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ehealth.models;

/**
 *
 * @author Akash
 */
public class BillModel {
    private RoomAlotmentModel alotmentModel;
    private TestPatientModel testPatientModel;
    private OperationResultModel operationResultModel;
    private Integer totaDays;
    private Integer grandTotal;
    private Integer totalTestCharges;
    private Integer totalOperationCharges;

    public TestPatientModel getTestPatientModel() {
        return testPatientModel;
    }

    public void setTestPatientModel(TestPatientModel testPatientModel) {
        this.testPatientModel = testPatientModel;
    }

    public OperationResultModel getOperationResultModel() {
        return operationResultModel;
    }

    public void setOperationResultModel(OperationResultModel operationResultModel) {
        this.operationResultModel = operationResultModel;
    }

    public Integer getTotalTestCharges() {
        return totalTestCharges;
    }

    public void setTotalTestCharges(Integer totalTestCharges) {
        this.totalTestCharges = totalTestCharges;
    }

    public Integer getTotalOperationCharges() {
        return totalOperationCharges;
    }

    public void setTotalOperationCharges(Integer totalOperationCharges) {
        this.totalOperationCharges = totalOperationCharges;
    }

    public RoomAlotmentModel getAlotmentModel() {
        return alotmentModel;
    }

    public void setAlotmentModel(RoomAlotmentModel alotmentModel) {
        this.alotmentModel = alotmentModel;
    }

    public Integer getTotaDays() {
        return totaDays;
    }

    public void setTotaDays(Integer totaDays) {
        this.totaDays = totaDays;
    }

    public Integer getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(Integer grandTotal) {
        this.grandTotal = grandTotal;
    }
}
