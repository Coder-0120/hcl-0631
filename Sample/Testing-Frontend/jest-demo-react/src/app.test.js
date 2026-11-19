import { greet } from "./App.jsx";

test("greet returns the correct greeting", () => {
    const expected = "Hello, World!";
    const actual = greet("World");

    expect(actual).toBe(expected);
});