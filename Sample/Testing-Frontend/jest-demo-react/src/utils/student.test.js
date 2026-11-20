import {isEligible} from './student';

describe("Student eligibility testing",()=>{
    test("Student with 85% attendance",()=>{
        expect((isEligible(85))).toBe(true);
    });
    test("Student with 60% attendance",()=>{
        expect((isEligible(60))).toBe(false);
    });
    test("Student with 75% attendance",()=>{
        expect((isEligible(75))).toBe(true);
    });
    test("Invalid attendance value",()=>{
        expect(()=>isEligible(110)).toThrow("Invalid Attendance");
    });
})