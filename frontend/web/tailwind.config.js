/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ["./src/**/*.{html,ts,css}"],
  theme: {
    extend: {
      colors: {
        "industrial-blue": "oklch(29.3% 0.066 243.157)",
        "industrial-white": "#f8fafc", // Um branco levemente acinzentado (Slate 50)
      }
    },
  },
  plugins: [],
}