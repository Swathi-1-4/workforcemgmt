/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Admin
 */
package com.yourcompany.workforcemgmt.dto;

import java.time.LocalDate;

public class CreateTaskRequest {

    public String title;
    public String assignedTo;
    public LocalDate startDate;
    public LocalDate dueDate;
}
