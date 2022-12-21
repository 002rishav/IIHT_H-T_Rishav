class Employee {
    //parent class
    constructor(company_name,emp_name,exp,dep,pos,join_date,loc,email_id,emp_id,salary) {
        this.company_name = "CTS";        
    }
}

class Developers extends Employee {
    constructor(emp_name,exp,dep,pos,join_date,loc,email_id,emp_id,salary) {
        super();// used to fetch the content of the constructor from parent class
        this.emp_name = emp_name;
        this.exp=exp;
        this.dep=dep;
        this.pos=pos;
        this.join_date=join_date;
        this.loc=loc;
        this.email_id=email_id;
        this.emp_id=emp_id;
        this.salary=salary;
    }
}

class HR extends Employee {
    constructor(emp_name,exp,dep,pos,join_date,loc,email_id,emp_id,salary) {
        super();// used to fetch the content of the constructor from parent class
        this.emp_name = emp_name;
        this.exp=exp;
        this.dep=dep;
        this.pos=pos;
        this.join_date=join_date;
        this.loc=loc;
        this.email_id=email_id;
        this.emp_id=emp_id;
        this.salary=salary;
    }
}

class Finance extends Employee {
    constructor(emp_name,exp,dep,pos,join_date,loc,email_id,emp_id,salary) {
        super();// used to fetch the content of the constructor from parent class
        this.emp_name = emp_name;
        this.exp=exp;
        this.dep=dep;
        this.pos=pos;
        this.join_date=join_date;
        this.loc=loc;
        this.email_id=email_id;
        this.emp_id=emp_id;
        this.salary=salary;
    }
}

class Sales extends Employee {
    constructor(emp_name,exp,dep,pos,join_date,loc,email_id,emp_id,salary) {
        super();// used to fetch the content of the constructor from parent class
        this.emp_name = emp_name;
        this.exp=exp;
        this.dep=dep;
        this.pos=pos;
        this.join_date=join_date;
        this.loc=loc;
        this.email_id=email_id;
        this.emp_id=emp_id;
        this.salary=salary;
    }
}

class Marketing extends Employee {
    constructor(emp_name,exp,dep,pos,join_date,loc,email_id,emp_id,salary) {
        super();// used to fetch the content of the constructor from parent class
        this.emp_name = emp_name;
        this.exp=exp;
        this.dep=dep;
        this.pos=pos;
        this.join_date=join_date;
        this.loc=loc;
        this.email_id=email_id;
        this.emp_id=emp_id;
        this.salary=salary;
    }
}

class QA extends Employee {
    constructor(emp_name,exp,dep,pos,join_date,loc,email_id,emp_id,salary) {
        super();// used to fetch the content of the constructor from parent class
        this.emp_name = emp_name;
        this.exp=exp;
        this.dep=dep;
        this.pos=pos;
        this.join_date=join_date;
        this.loc=loc;
        this.email_id=email_id;
        this.emp_id=emp_id;
        this.salary=salary;
    }
}

let l1=new Developers("Rishav","3","FSE","Associate","2022-11-18","Kolkata","rishav@gmail.com","101","10000");
console.log(l1.company_name+" "+l1.emp_name+" "+l1.exp+" "+l1.dep+" "+l1.pos+" "+l1.join_date+" "+l1.loc+" "+l1.email_id+" "+l1.emp_id+" "+l1.salary);

let l2=new HR("Nishant","3","FSE","Associate","2022-11-18","Kolkata","nishant@gmail.com","101","10000");
console.log(l2.company_name+" "+l2.emp_name+" "+l2.exp+" "+l2.dep+" "+l2.pos+" "+l2.join_date+" "+l2.loc+" "+l2.email_id+" "+l2.emp_id+" "+l2.salary);
let l3=new Finance("Harsh","3","FSE","Associate","2022-11-18","Kolkata","harsh@gmail.com","101","10000");
console.log(l3.company_name+" "+l3.emp_name+" "+l3.exp+" "+l3.dep+" "+l3.pos+" "+l3.join_date+" "+l3.loc+" "+l3.email_id+" "+l3.emp_id+" "+l3.salary);
let l4=new Sales("Kumar","3","FSE","Associate","2022-11-18","Kolkata","kumar@gmail.com","101","10000");
console.log(l4.company_name+" "+l4.emp_name+" "+l4.exp+" "+l4.dep+" "+l4.pos+" "+l4.join_date+" "+l4.loc+" "+l4.email_id+" "+l4.emp_id+" "+l4.salary);

let l5=new Marketing("Parnava","3","FSE","Associate","2022-11-18","Kolkata","parnava@gmail.com","101","10000");
console.log(l5.company_name+" "+l5.emp_name+" "+l5.exp+" "+l5.dep+" "+l5.pos+" "+l5.join_date+" "+l5.loc+" "+l5.email_id+" "+l5.emp_id+" "+l5.salary);

let l6=new QA("Sayan","3","FSE","Associate","2022-11-18","Kolkata","sayan@gmail.com","101","10000");
console.log(l6.company_name+" "+l6.emp_name+" "+l6.exp+" "+l6.dep+" "+l6.pos+" "+l6.join_date+" "+l6.loc+" "+l6.email_id+" "+l6.emp_id+" "+l6.salary);