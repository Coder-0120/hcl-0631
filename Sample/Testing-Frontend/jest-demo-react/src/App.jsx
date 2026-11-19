export function greet(name) {
    return `Hello, ${name}!`;
}

const App = () => {
    return (
        <div>
            <h1>Jest Testing Practice</h1>
            <p>{greet("World")}</p>
        </div>
    );
};

export default App;