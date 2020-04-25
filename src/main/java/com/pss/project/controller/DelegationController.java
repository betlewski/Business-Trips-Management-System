package com.pss.project.controller;

import com.pss.project.model.Delegation;
import com.pss.project.service.DelegationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/delegation")
@CrossOrigin
public class DelegationController {

    private DelegationService delegationService;

    @Autowired
    public DelegationController(DelegationService delegationService) {
        this.delegationService = delegationService;
    }

    @PostMapping("/add")
    public ResponseEntity<Delegation> add(@RequestParam("id") Long id,
                                          @ModelAttribute("delegation") Delegation delegation){
        return delegationService.addDelegation(id, delegation);
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public ResponseEntity<Boolean> remove(@RequestParam("userId") Long userId,
                                          @RequestParam("delegationId") Long delegationId){
        return delegationService.removeDelegation(userId, delegationId);
    }

    @PutMapping("/change")
    public ResponseEntity<Delegation> change(@RequestParam("id") Long id,
                                             @ModelAttribute("delegation") Delegation delegation){
        return delegationService.changeDelegation(id, delegation);
    }

    @GetMapping("/all")
    @ResponseBody
    public List<Delegation> getAll(){
        return delegationService.getAllDelegations();
    }

    @GetMapping("/allInOrder")
    @ResponseBody
    public List<Delegation> getAllInOrder(){
        return delegationService.getAllDelegationsOrderByDateTimeStartDesc();
    }

    @GetMapping("allByUser")
    @ResponseBody
    public List<Delegation> getAllByUserInOrder(@RequestParam("id") Long id){
        return delegationService.getAllDelByUserByDateTimeStartDesc(id);
    }
}
