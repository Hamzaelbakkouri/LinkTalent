// import React, { useRef, useEffect } from "react";
// import { useGLTF, Float } from "@react-three/drei";

// import * as THREE from "";

// export function Model(props: any) {
//     const { nodes } = useGLTF('/medias/Moon.glb');
//     const meshRef = useRef<THREE.Mesh>(null);
//     const centerModelRef = useRef<THREE.Mesh>(null);
//     const radius = 2; // Radius of the circular path
//     let angle = 0; // Initial angle

//     useEffect(() => {
//         const animate = () => {
//             // Increment angle (you can adjust speed by changing the increment value)
//             angle += 0.005;

//             // Calculate new position
//             // @ts-ignore
//             const x = centerModelRef.current.position.x + radius * Math.cos(angle);
//             // @ts-ignore
//             const y = centerModelRef.current.position.y - radius * Math.sin(angle); // Adjusted for y-axis
//             // @ts-ignore
//             const z = centerModelRef.current.position.z;

//             // Update mesh position
//             if (meshRef.current) {
//                 meshRef.current.position.set(x, y, z);
//             }

//             // Request animation frame
//             requestAnimationFrame(animate);
//         };

//         // Start animation
//         animate();

//         // Clean up
//         return () => {
//             // @ts-ignore
//             cancelAnimationFrame(animate);
//         };
//     }, []);

//     return (
//         <group {...props} dispose={null}>
//             <mesh
//                 ref={meshRef}
//                 geometry={(nodes.SM_moon1 as THREE.Mesh).geometry}
//                 material={(nodes.SM_moon1 as THREE.Mesh).material}
//                 scale={0.003}
//             />
//             <mesh
//                 ref={meshRef}
//                 geometry={(nodes.SM_moon1 as THREE.Mesh).geometry}
//                 material={(nodes.SM_moon1 as THREE.Mesh).material}
//                 scale={0.003}
//             />
//             <mesh
//                 ref={meshRef}
//                 geometry={(nodes.SM_moon1 as THREE.Mesh).geometry}
//                 material={(nodes.SM_moon1 as THREE.Mesh).material}
//                 scale={0.003}
//             />
//             <mesh ref={centerModelRef} position={[0, 0, 0]}>
//                 <sphereGeometry args={[0.1, 32, 32]} />
//                 <meshBasicMaterial color="red" />
//             </mesh>
//         </group>
//     );
// }

// useGLTF.preload('/medias/Moon.glb');
