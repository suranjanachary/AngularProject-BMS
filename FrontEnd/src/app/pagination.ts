
import { Content } from "./content";
import { Pageable } from "./pageable";
import { Sort } from "./sort";

export class Pagination{

    content : Content [] = [];
    pageable : Pageable;
    last : boolean;
    totalElements : number; 
    totalPages : number = 10; 
    size : number;
    number : number; 
    sort: Sort;
    first : boolean; 
    numberOfElements: number;
    empty: boolean;
}