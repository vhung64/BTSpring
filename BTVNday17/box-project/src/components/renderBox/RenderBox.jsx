import React from 'react'
function RenderBox(props) {
    const colors = props.listColor;
    const deleteColor = (index) => {
      
    }
  return (
    <>
    {Object.values(colors).map((val, index) => (
        <div key={index} className="box" style={{backgroundColor : val}} onClick={deleteColor(index)}></div>
    ))}
    </>
  )
}

export default RenderBox