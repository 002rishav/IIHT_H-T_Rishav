import { Pipe, PipeTransform } from '@angular/core';
import { __param } from 'tslib';

@Pipe({
  name: 'ellipsis'
})
export class EllipsisPipe implements PipeTransform {

  transform(value: string, ...args: string[]): unknown {
    let val;
    if(args[0] === 'full'){
      val = value;
    }else if(value.length > 30){
      val = value.substring(0,30) + "...";
    }
    return val;
  }

}
