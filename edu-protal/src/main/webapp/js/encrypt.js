/**
 * 
 */
function encrypt(content, key) {  
			
			key = CryptoJS.enc.Utf8.parse(key);  
		    var encryptResult = CryptoJS.AES.encrypt(content, key, {  
		        //iv: key,  
		        mode: CryptoJS.mode.ECB,  
		        padding: CryptoJS.pad.Pkcs7  
		    });  
		    return encryptResult.toString();  
}