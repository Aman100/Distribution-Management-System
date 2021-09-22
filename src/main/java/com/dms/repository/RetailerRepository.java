package com.dms.repository;

import com.dms.model.*;
import org.springframework.data.repository.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;

public interface RetailerRepository extends CrudRepository<Retailer,Integer>
{
Retailer findById(int id);
List<Retailer> findAll();
@Query(value="select * from Retailer where r_name=?1",nativeQuery=true)
public Retailer getRetailerByName(String name);
@Query(value="select r.r_name,s.sim_name,s.price as sprice,s.description, et.et_name,et.price as etprice,et.et_description, rc.rc_name,rc.price as rcprice,rc.rc_description from Retailer_inventory ri INNER JOIN Retailer r ON r.r_id=ri.r_id INNER JOIN sim_cards s ON s.sim_id=ri.sim_id INNER JOIN E_topups et ON et.et_id=ri.et_id INNER JOIN recharge_coupons rc ON rc.rc_id=ri.rc_id where r.r_id=?1",nativeQuery=true)
public List<RetailerInventory> getRetailerInventoryById(Integer r_id);
@Query(value="select r.r_name,s.sim_name,s.price as sprice,s.description, et.et_name,et.price as etprice,et.et_description, rc.rc_name,rc.price as rcprice,rc.rc_description from Retailer_inventory ri INNER JOIN Retailer r ON r.r_id=ri.r_id INNER JOIN sim_cards s ON s.sim_id=ri.sim_id INNER JOIN E_topups et ON et.et_id=ri.et_id INNER JOIN recharge_coupons rc ON rc.rc_id=ri.rc_id",nativeQuery=true)
public List<RetailerInventory> getRetailersInventory();

@Transactional()
@Modifying()
@Query(value="insert into retailer_distributor_mapping(r_id,d_id) values(?1,?2)",nativeQuery=true)
public void saveMapping(Integer r_id,Integer d_id);

@Query(value="select d.d_id,d.d_name,d.area,d.address,s.sim_name,s.price as sprice,s.description, et.et_name,et.price as etprice,et.et_description, rc.rc_name,rc.price as rcprice,rc.rc_description from retailer_distributor_mapping rdm INNER JOIN distributor d ON d.d_id=rdm.d_id INNER JOIN sim_cards s ON s.sim_id=rdm.sim_id INNER JOIN E_topups et ON et.et_id=rdm.et_id INNER JOIN recharge_coupons rc ON rc.rc_id=rdm.rc_id where r_id=?1")

}