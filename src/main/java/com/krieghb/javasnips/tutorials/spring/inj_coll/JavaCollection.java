package com.krieghb.javasnips.tutorials.spring.inj_coll;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

@SuppressWarnings("rawtypes")
public class JavaCollection {

	List addressList;
	Set addressSet;
	Map addressMap;
	Properties addressProp;
	
	//  a setter method to set the list.
	public void setAddressList(List addressList) {
		this.addressList = addressList;
	}

	//  a setter method to set the set.
	public void setAddressSet(Set addressSet) {
		this.addressSet = addressSet;
	}

	//  a setter method to set the map.
	public void setAddressMap(Map addressMap) {
		this.addressMap = addressMap;
	}

	//  a setter method to set the property.
	public void setAddressProp(Properties addressProp) {
		this.addressProp = addressProp;
	}
	
	
	//  a getter to get the list.
	public List getAddressList() {
		System.out.println("List Elements:  "  + addressList);
		return addressList;
	}

	//  a getter to get the set.
	public Set getAddressSet() {
		System.out.println("Set Elements:  "  + addressSet);
		return addressSet;
	}

	//  a getter to get the Map.
	public Map getAddressMap() {
		System.out.println("Map Elements:  "  + addressMap);
		return addressMap;
	}

	//  a getter to get the properties.
	public Properties getAddressProp() {
		System.out.println("Property Elements:  "  + addressProp);
		return addressProp;
	}
	
	
}
