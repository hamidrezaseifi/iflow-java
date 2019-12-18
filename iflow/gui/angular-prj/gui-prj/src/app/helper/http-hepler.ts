import { HttpHeaders, HttpParams, HttpClient } from '@angular/common/http';

import { environment } from '../../environments/environment';

export const InterceptorUseHeader = 'X-Use-Interceptor';

export class HttpHepler {
	public static generateFormHeader(): HttpHeaders{
		
		var header :HttpHeaders  = new HttpHeaders({
  		    'Content-Type':  'application/x-www-form-urlencoded',
  		    'Authorization': 'my-auth-token'
		});
		
		if (environment.fake === true) {
			header = new HttpHeaders({
	  		    'Content-Type':  'application/x-www-form-urlencoded',
	  		    'Authorization': 'my-auth-token',
	  		    'X-Use-Interceptor' : 'user-fake'
			});
		}
		
		//alert(header.keys());
		
		return header;
	}

	public static generateJsonHeader(): HttpHeaders{
		
		var header :HttpHeaders  = new HttpHeaders({
			'Content-Type':  'application/json; charset=UTF-8',
  		    'Authorization': 'my-auth-token'
		});
		
		if (environment.fake === true) {
			header = new HttpHeaders({
	  		    'Content-Type':  'application/json; charset=UTF-8',
	  		    'Authorization': 'my-auth-token',
	  		    'X-Use-Interceptor' : 'user-fake'
			});
		}
		//alert(header.keys());
		
		return header;
	}

	public static generateFileUploadHeader(): HttpHeaders{
		
		var header :HttpHeaders  = new HttpHeaders({
			//'Content-Type' : undefined
		});
		
		if (environment.fake === true) {
			header = new HttpHeaders({
				//'Content-Type' : undefined,
	  		    'X-Use-Interceptor' : 'user-fake'
			});
		}
		//alert(header.keys());
		
		return header;
	}

}
