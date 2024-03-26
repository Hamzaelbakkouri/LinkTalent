
import React, { useRef } from 'react'
import { useGLTF } from '@react-three/drei'



export function Model(props) {
  const { nodes, materials } = useGLTF('/medias/Moon.glb')
  return (
    <group {...props} dispose={null}>
      <mesh geometry={nodes.SM_moon1.geometry} material={nodes.SM_moon1.material} scale={0.01} />
    </group>
  )
}

useGLTF.preload('/medias/Moon.glb')
