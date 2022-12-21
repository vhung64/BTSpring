import { useState } from 'react';
import './App.css';
function App() {
  let colors = [
    '#3498db',
    '#9b59b6',
    '#e74c3c',
    '#2c3e50',
    '#d35400',
  ]
  const [listColor, setListColor] = useState(colors);
  const [count, setCount] = useState(5);
  const renderMoreBox = () => {
    let list = listColor;
    list.push('#3498db', '#9b59b6', '#e74c3c', '#2c3e50', '#d35400');
    setListColor(list);
    setCount(count + 5);
  };
  const deleteColor = (index) => {
    let list = listColor;
    list.splice(index,1)
    setListColor(list);
    setCount(count-1);

  }
  return (
    <div className="wrap">
      <h1> JS DOM</h1>
      <button id="btn" onClick={renderMoreBox}>More boxes</button>
      <h4 id="score"> Total box:<span className="points">{count}</span></h4>
      <div className="boxes">
        {Object.values(listColor).map((val, index) => (
        <div key={index} className="box" style={{backgroundColor : val}} onClick={() => deleteColor(index)}>{index}</div>
          ))}
      </div>
    </div>
  );
}
export default App;
