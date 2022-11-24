package com.example.practica.service

import com.example.practica.model.Member
import com.example.practica.repository.MemberRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class MemberService {

    @Autowired
    lateinit var memberRepository: MemberRepository

    fun list():List<Member>{
        return memberRepository.findAll()
    }

    fun save(member:Member):Member{
        return memberRepository.save(member)
        memberRepository.findById(member.id) ?: throw Exception("10 no existe")
    }

    fun update(member: Member):Member{
        try{
            memberRepository.findById(member.id)
                ?: throw Exception("ID no existe")
            return memberRepository.save(member)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun updateName(member:Member): Member {
        try{
            val response = memberRepository.findById(member.id)
                ?: throw Exception("ID no existe")
            response.apply {
                fullname=member.fullname
            }
            return memberRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

}