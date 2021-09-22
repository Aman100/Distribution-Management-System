package com.dms.model;

import javax.persistence.*;
import java.util.*;
@Entity()
public class Distributor
{
@Id()
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int d_id;
private String d_name;
private String area;
private String address;
/*
@ManyToMany(mappedBy="distributors")
private List<Retailer> retailers;
public void setRetailers(List<Retailer> retailers)
{
this.retailers=retailers;
}
public List<Retailer> getRetailers()
{
return this.retailers;
}
*/
public Distributor()
{
}

public Distributor(int d_id,String d_name, String area, String address)
{
this.d_id=d_id;
this.d_name=d_name;
this.area=area;
this.address=address;
}
public int getD_id()
{
return this.d_id;
}

public void setD_id(int d_id)
{
this.d_id = d_id;
}

public String getD_name()
{
return this.d_name;
}

public void setD_name(String d_name)
{
this.d_name = d_name;
}

public String getArea()
{
return this.area;
}

public void setArea(String area)
{
this.area = area;
}

public String getAddress()
{
return this.address;
}

public void setAddress(String address) 
{
this.address = address;
}

}