import React,{Component} from "react";
import'./footer.css'

class Footer extends Component {
 
  render(){
    return(
      <>
      <hr/>
      <div className="footer-body">
        <span><b>(주)원데이씨드</b> <br/>
        <span className="our-info">서울시 종로구 인사동길 12 15층 <br/>
         사업자등록번호 : 135-87-***** | 통신판매업 : 신고번호 제2024-서울종로-987**호  <br/>
         </span> <br/>
         <span className="not-host">(주)원데이씨드는 통신판매중개자이며, 통신판매의 당사자가 아닙니다. 상품, 상품정보, 거래에 관한 의무와 책임은 판매자에게 있습니다.</span>
        </span>
        <br/><br/><br/><br/>
      </div>
      </>
    )
  }
}

export default Footer;