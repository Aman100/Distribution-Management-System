package com.dms.model;
public interface RetailerInventory
{
@ManyToMany()
@JoinTable(name="retailer_distributor_mapping",joinColumns=@JoinColumn(name="r_id"),inverseJoinColumns=@JoinColumn(name="d_id"))
String getR_name();
String getSim_name();
Integer getSprice();
String getDescription();
String getEt_name();
Integer getEtprice();
String getEt_description();
String getRc_name();
Integer getRcprice();
String getRc_description();
}