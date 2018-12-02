package com.example.sdBank;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.example.sdBank.entity.BankBranch;
import com.example.sdBank.entity.Banks;
import com.example.sdBank.service.BankService;

import junit.framework.Assert;

public class BankServiceTest {
@Test
public void getBranchDetailsTest(){
	BankService bankService=new BankService();
	BankBranch bb=new BankBranch();
	bb.setBankId(25);
	bb.setBranch("AKOLA");
	bb.setCity("AKOLA");
	bb.setDistrict("AKOLA");
	bb.setIfsc("BKDN0520825");
	bb.setState("MAHARASHTRA");
	bb.setBankName("DENA BANK");
	
	BankBranch br=bankService.getBranchDetails("BKDN0520825");
	Assert.assertEquals(bb, br);
	
}
@Test
public void getAllBranchesInCityTest(){
	BankService bankService=new BankService();
	List<BankBranch> exBranches=new ArrayList<>();
	BankBranch bb=new BankBranch();
	bb.setBankId(25);
	bb.setBranch("AKOLA");
	bb.setCity("AKOLA");
	bb.setDistrict("AKOLA");
	bb.setIfsc("BKDN0520825");
	bb.setState("MAHARASHTRA");
	bb.setBankName("DENA BANK");
	
	List<BankBranch> branches=bankService.getAllBranchesInCity("DENA BANK", "AKOLA");
	Assert.assertEquals(exBranches, branches);
	
}
}
