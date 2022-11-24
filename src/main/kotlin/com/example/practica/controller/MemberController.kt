package com.example.practica.controller

import com.example.practica.model.Member
import com.example.practica.service.MemberService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/member")
class MemberController{

    @Autowired
    lateinit var memberService: MemberService

    @GetMapping
    fun list():List<Member>{
        return memberService.list()
    }

    @PostMapping
    fun save(@RequestBody @Valid member: Member):Member{
        return memberService.save(member)
    }

    @PutMapping
    fun update (@RequestBody member: Member): ResponseEntity<Member>{
        return ResponseEntity(memberService.update(member),HttpStatus.OK )
    }

    @PatchMapping
    fun updateName (@RequestBody member:Member):ResponseEntity<Member>{
        return ResponseEntity(memberService.updateName(member), HttpStatus.OK)
    }

}