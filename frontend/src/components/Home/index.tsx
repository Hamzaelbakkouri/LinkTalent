import React, { useRef } from "react";
import { Canvas, useFrame } from "@react-three/fiber";
import { OrbitControls, Sphere } from "@react-three/drei";
import { pointsInner, pointsOuter } from "@/utils";

const ParticleRing = () => {
    return (
        <>
            <Canvas
                camera={{
                    position: [10, -7.5, -5],
                }}
                style={{ height: "100vh" }}
                className="bg-slate-900"
            >
                <OrbitControls maxDistance={20} minDistance={10} />
                <directionalLight />
                <pointLight position={[-30, 0, -30]} power={10.0} />
                <PointCircle />
            </Canvas>

            <h1 className="absolute uppercase top-[50%] left-[50%] -translate-x-[50%] -translate-y-[50%] text-white font-medium text-2xl md:text-5xl pointer-events-none bg-opacity-85 bg-[#27292F] cursor-pointer hover:bg-[#33353D] hover:text-[#45a3fce3] border border-gray-600 rounded-md py-8 px-12 flex">
                <p>Welcome To</p><p>&#160;</p> <p className="text-[#2091fae3]">LinkTalent</p>
            </h1>
            {/* <div>
            <HeroScrollDemo />
            </div> */}
        </>
    );
};

const PointCircle = () => {
    const ref = useRef(null);

    useFrame(({ clock }) => {
        // @ts-ignore
        if (ref.current?.rotation) {
            // @ts-ignore
            ref.current.rotation.z = clock.getElapsedTime() * 0.05;
        }
    });

    return (
        <group ref={ref}>
            {pointsInner.map((point) => (
                <Point key={point.idx} position={point.position} color={point.color} />
            ))}
            {pointsOuter.map((point) => (
                <Point key={point.idx} position={point.position} color={point.color} />
            ))}
        </group>
    );
};

const Point = ({ position, color }: any) => {
    return (
        <Sphere position={position} args={[0.1, 10, 10]}>
            <meshStandardMaterial
                emissive={color}
                emissiveIntensity={0.5}
                roughness={0.5}
                color={color}
            />
        </Sphere>
    );
};

export default ParticleRing;