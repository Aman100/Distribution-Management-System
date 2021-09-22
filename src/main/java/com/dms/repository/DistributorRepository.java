package com.dms.repository;

import com.dms.model.*;
import org.springframework.data.repository.*;
import org.springframework.data.jpa.repository.Query;
import java.util.*;

public interface DistributorRepository extends CrudRepository<Distributor,Integer>
{
Distributor findById(int id);
List<Distributor> findAll();
@Query(value="select * from distributor where d_name=?1",nativeQuery=true)
public Distributor getDistributorByName(String name);
@Query(value="select d.d_name,s.sim_name,s.price as sprice,s.description, et.et_name,et.price as etprice,et.et_description, rc.rc_name,rc.price as rcprice,rc.rc_description from distributor_inventory di INNER JOIN distributor d ON d.d_id=di.d_id INNER JOIN sim_cards s ON s.sim_id=di.sim_id INNER JOIN E_topups et ON et.et_id=di.et_id INNER JOIN recharge_coupons rc ON rc.rc_id=di.rc_id where d.d_id=?1",nativeQuery=true)
public List<DistributorInventory> getDistributorInventoryById(Integer d_id);
@Query(value="select d.d_name,s.sim_name,s.price as sprice,s.description, et.et_name,et.price as etprice,et.et_description, rc.rc_name,rc.price as rcprice,rc.rc_description from distributor_inventory di INNER JOIN distributor d ON d.d_id=di.d_id INNER JOIN sim_cards s ON s.sim_id=di.sim_id INNER JOIN E_topups et ON et.et_id=di.et_id INNER JOIN recharge_coupons rc ON rc.rc_id=di.rc_id",nativeQuery=true)
public List<DistributorInventory> getDistributorsInventory();
}