package com.example.sdBank.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sdBank.entity.BankBranch;
import com.example.sdBank.entity.Banks;
import com.example.sdBank.entity.Branches;
import com.example.sdBank.repository.BankRepository;
import com.example.sdBank.repository.BranchRepository;
@Service
public class BankService {
	@Autowired
	BranchRepository branchRepo;
	@Autowired
	BankRepository bankRepo;
	public BankBranch getBranchDetails(String ifsc) {
		
		Branches branches= branchRepo.findById(ifsc).orElse(new Branches());
		BankBranch bb=new BankBranch();
		bb.setBankId(branches.getBankId());
		bb.setBranch(branches.getBranch());
		bb.setCity(branches.getCity());
		bb.setDistrict(branches.getDistrict());
		bb.setIfsc(branches.getIfsc());
		bb.setState(branches.getState());
		bb.setBankName(bankRepo.findById(branches.getBankId()).orElse(new Banks()).getName());
		return bb;
	}

	public List<BankBranch> getAllBranchesInCity(String bankName, String city) {
		
		Integer id=bankRepo.getIdByName(bankName);
		List<Branches> branches =  branchRepo.getBranchesByCity(id,city);
		List<BankBranch> bbList=new ArrayList<>();
		for(Branches branch:branches) {
		BankBranch bb=new BankBranch();
		bb.setBankId(branch.getBankId());
		bb.setBranch(branch.getBranch());
		bb.setCity(branch.getCity());
		bb.setDistrict(branch.getDistrict());
		bb.setIfsc(branch.getIfsc());
		bb.setBankName(bankName);
		bb.setState(branch.getState());
		bbList.add(bb);
		}
		return bbList;
	}

}
