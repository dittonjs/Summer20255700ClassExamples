import { useState } from 'react'
import './App.css'

function App() {
  const [input, setInput] = useState<string>('')
  const [focused, setFocused] = useState<boolean>(false)
  const [submitted, setSubmitted] = useState<boolean>(false)
  const [invalid, setInvalid] = useState<boolean>(false)
  const style = {
    border: focused ? '2px solid blue' : '1px solid gray',
    backgroundColor: invalid ? 'lightcoral' :
      submitted ? 'lightgreen' : 'white',
    color: "black",
    padding: '8px',
    outline: 'none',
  }

  return (
    <>
      <input type="text"
        value={input}
        style={style}
        onChange={(e) => {
          setInput(e.target.value)
          setInvalid(false)
        }}
        onFocus={() => setFocused(true)}
        onBlur={() => setFocused(false)}
      />
      <button onClick={() => {
        if (submitted) return
        if (!input) {
          setInvalid(true)
        } else {
          setSubmitted(true)
          setInvalid(true)
        }
      }}>Submit</button>
    </>
  )
}

export default App
