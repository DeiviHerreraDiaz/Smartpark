const divisiones = document.querySelectorAll(".division");

divisiones.forEach((division) => {
  division.addEventListener("mousemove", (e) => {
    const x = e.clientX - division.getBoundingClientRect().left;
    const y = e.clientY - division.getBoundingClientRect().top;

    const gradient = `radial-gradient(circle at ${x}px ${y}px, #73c73c, rgb(57, 169, 0))`;

    division.style.background = gradient;
  });

  division.addEventListener("mouseleave", () => {
    division.style.background = "#39A900";
  });
});
