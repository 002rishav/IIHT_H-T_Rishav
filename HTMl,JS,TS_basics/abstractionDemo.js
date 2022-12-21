function Car(color, model,cost,fuelType){
    this.color=color;
    this.model=model;
    this.cost=cost;
    this.fuelType=fuelType;
    let runningCostPerYear= 30000;

    this.getCarDetails = function() {
        console.log("Color: "+color);
        console.log("Model: "+this.model);
        console.log("Cost: "+this.cost);
        console.log("fuelType: "+this.fuelType);
        console.log("Running cost of car per Year: "+this.runningCostPerYear);
    }

    this.totalCostOfOwnership= function(){
        console.log(runningCostPerYear + cost);
    }
}

let MercedesCclass = new Car("Red","C class",5000000,"Petrol");
MercedesCclass.getCarDetails();
MercedesCclass.runningCostPerYear=90000;
//MercedesCclass.getCarDetails();
console.log(MercedesCclass.totalCostOfOwnership());