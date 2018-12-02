package com.example.sdBank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.sdBank.entity.BankBranch;
import com.example.sdBank.entity.Branches;
import com.example.sdBank.service.BankService;

@Controller
public class SdBankController {
	
	@Autowired
	BankService bankService;
	
	
	
	@RequestMapping("/")
    @ResponseBody
    public String home() {
      return "Welcome to the app<br><b>get branch details with ifsc:</b>/getBranchDetails/{ifsc}\r\n"
      		+ "<br><b>get all branches in a city :</b> /getAllBranchesInCity/{bankName}/{city}";
    }
	@RequestMapping("/getBranchDetails/{ifsc}")
    @ResponseBody
    public BankBranch getBranchDetails(@PathVariable String ifsc ) {
      return bankService.getBranchDetails(ifsc);
    }
	
	@RequestMapping("/getAllBranchesInCity/{bankName}/{city}")
    @ResponseBody
    public List<BankBranch> getAllBranchesInCity(@PathVariable String bankName ,@PathVariable String city ) {
      return bankService.getAllBranchesInCity(bankName,city);
    }
}
