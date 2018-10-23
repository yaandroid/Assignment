package yang.com.assingnment

import yang.com.assingnment.Domain.DomainResponse

interface mDomainResponse{
        fun Onsuccess(domainResponse: DomainResponse)
        fun OnFail(error : String)
    }