//import axios from 'axios'
let basePath = "http://localhost:8081";

export const requestData=function(params,path,successback,failback){
  let method=params.method==="GET"?"GET":"POST";
  var request = {
    url: basePath + path,
    method: method,
  };
  if (method==='GET'){
    request.params=params;
  }else {
    request.data=qs.stringify({...params});
  };
  delete params.method;  //删除请求参数中的方式
}
