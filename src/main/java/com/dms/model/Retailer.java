package com.dms.model;

import javax.persistence.*;
import java.util.*;
@Entity()
public class Retailer
{
@Id()
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int r_id;
private String r_name;
private String area;
private String address;
public Retailer()
{
}
public Retailer(int r_id,String r_name, String area, String address)
{
this.r_id=r_id;
this.r_name=r_name;
this.area=area;
this.address=address;
}
public int getr_id()
{
return this.r_id;
}

public void setr_id(int r_id)
{
this.r_id = r_id;
}

public String getr_name()
{
return this.r_name;
}

public void setr_name(String r_name)
{
this.r_name = r_name;
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