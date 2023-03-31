export class CompanyUserRequest {

 userId!:number
 firstName!:string
	lastName!:string

	 gender!:string;
	 birthdate!:Date;

	// Address
	 country!:string
	 governorate!:string
	 city!:string
	 zipCode!:number
	homeCode!:number

	// Contact
	 email!:string
	 phoneNumber!:number

	// employee
matriculeFiscale!:string

	 status!:string

	// TA && DRIVER && admin
societeRemorquageId!:number

	// Authentication
 username!:string
	 password!:string
	 confirmPassword!:string
}
